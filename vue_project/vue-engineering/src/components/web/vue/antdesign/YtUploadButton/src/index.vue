<template>
  <a-upload class="webVueAntYtUpload" v-model:fileList="fileListData" :accept="accept"
    :maxCount="maxCount" :multiple="multiple" :showUploadList="showUploadList" :beforeUpload="beforeUpload"
    :listType="listType" :disabled="disabled" @preview="previewFile" @change="handleChange" v-bind="filteredProps">
    <a-button :disabled="disabled">
      <template #icon>
        <img class="upload-icon" :src="iconUrl" alt=""/>
      </template>
      {{ buttonContent || '点击上传' }}
    </a-button>
  </a-upload>
</template>

<script>
import i18next from 'i18next'
import { createLocaleLang } from '../../../../../../shared/createLocaleLang'
i18next.init({
  lng: window.__$yt_lang, // 默认语言
  resources: createLocaleLang(import.meta.globEager('./locales/**/data.json'))
})

export default {
  name: "yt-upload-button-inner",
  inheritAttrs: false,
  props: {
    showUploadList: Boolean,
    listType: String,
    buttonContent: String,
    preview: Boolean,
    canDownload: Boolean,
    accept: String,
    maxCount: Number,
    multiple: Boolean,
    disabled: Boolean,
    fileList: Array,
  },
  data () {
    return {
      fileListData: [],
      iconUrl:'./staticResource/public/upload.svg'
    }
  },
  computed: {
    filteredProps() {
      // 创建一个不包含prop2的新对象
      const { onChange,  ['onUpdate:fileList']: onUpdateFileList, ...rest } = this.$attrs;
      return rest;
    },
  },
  mounted () {
  },
  methods: {
    beforeUpload(file){
      this.fileListData = [...this.fileListData, file];
      this.$emit('update:fileList', this.fileListData)
      this.$emit('changeList', this.fileListData)
      this.$emit('change', this.fileListData)
      return false;
    },
    previewFile (file) {
      // console.log(file)
      const name = file.name
      const url = file.url || null
      if (this.canDownload) {
        if (url) {
          this.downloadAllFile(url, name)
        } else {
          this.fileToBase64(file.originFileObj).then(base64 => {
            this.downLoad(this.base64toBlob(base64), name)
          })
        }
        this.$emit('toDowload', file)
      }
      if (this.preview) {
        if (file.originFileObj) {
          const reader = new FileReader()
          reader.readAsDataURL(file.originFileObj)
          reader.onload = () => {
            this.createPreview(reader.result, false, true)
          }
        } else if (file.url || file.thumbUrl) {
          this.createPreview(file.url || file.thumbUrl, true)
        }
      }
      this.$emit('toPreview', file)
    },
    downloadAllFile (imgsrc, name) {//下载图片地址和图片名
      blobUrlTofile(imgsrc).then(res => {
        const blob = new Blob([res], { type: "application/msword;charset=utf-8" })
        try {
          const href = window.URL.createObjectURL(blob)
          this.downloadFile(href, name)
        } catch {
          this.downloadIamge(imgsrc, name, res)
        }
      })
    },
    async blobUrlTofile (blobUrl) {
      let file = {}
      const config = { responseType: 'blob' }
      const response = await axios.get(blobUrl, config)
      file = new window.File([response.data], 'file', { type: 'image/png' })
      return file
    },
    downloadFile (url, name) {
      let a = document.createElement("a") // 生成一个a元素
      a.href = url
      let event = new MouseEvent("click") // 创建一个单击事件
      a.download = name || "photo" // 设置图片名称
      a.dispatchEvent(event) // 触发a的单击事件
    },
    downloadIamge (imgsrc, name, file) {//下载图片地址和图片名
      let image = new Image()
      // 解决跨域 Canvas 污染问题
      image.setAttribute("crossOrigin", "anonymous")
      image.onload = function () {
        fileToBase64(file).then((base64) => {
          this.downloadFile(base64, name)
        })
      }
      image.src = imgsrc
    },
    downLoad (file, name, url) {
      const link = document.createElement('a')
      link.download = file.name || name
      link.style.display = 'none'
      link.href = url || URL.createObjectURL(file)
      link.target = '_blank'
      link.click()
    },
    fileToBase64 (file) {
      //file转bse64
      return new Promise((resolve, reject) => {
        let reader = new FileReader()
        reader.readAsDataURL(file)
        reader.onload = function (e) {
          resolve(e.target.result)
        }
      })
    },
    createPreview (base64, isUrl, canDownload, name) {
      let currBase64 = base64
      const handle = window.open()
      let file = !isUrl ? this.base64ToFile(base64) || {} : {}
      let reg = /image\/*/
      let regB = /.*\/pdf/
      let isImage = reg.test(file.type)
      let isPdf = regB.test(file.type)
      if (file.type && !isImage && !isPdf) {
        currBase64 = ''
        if (!canDownload && name) {
          const href = window.URL.createObjectURL(file)
          this.downloadFile(href, name)
        }
      }

      handle.document.write(`
      <html>
        <style>
          html, body { padding: 0; margin: 0; } 
          iframe { width: 100%; height: 100%; border: 0; text-align: center; }  
        </style>
        <body>
          <iframe src="${currBase64}"></iframe>
        </body>
      </html>
      `)

      handle.document.body.style.background = '#000'
    },
    base64ToFile (dataurl, filename) {
      //将base64转换为文件
      var arr = dataurl.split(','),
        mime = arr[0].match(/:(.*?);/)[1],
        bstr = atob(arr[1]),
        n = bstr.length,
        u8arr = new Uint8Array(n)
      while (n--) {
        u8arr[n] = bstr.charCodeAt(n)
      }
      return new File([u8arr], filename, { type: mime })
    },
    base64toBlob (dataurl) {
      //base64转blob
      var arr = dataurl.split(','),
        mime = arr[0].match(/:(.*?);/)[1],
        bstr = atob(arr[1]),
        n = bstr.length,
        u8arr = new Uint8Array(n)
      while (n--) {
        u8arr[n] = bstr.charCodeAt(n)
      }
      return new Blob([u8arr], { type: mime })
    },
    handleChange ({file}) {
      if (file.status === 'error') {
        file.status = 'done'
      }
      this.$emit('update:fileList', this.fileListData)
      this.$emit('changeList', this.fileListData)
      this.$emit('change', this.fileListData)
    }
  }
}
</script>

<style lang="less" scoped>
.webVueAntYtUpload {
  .ant-btn {
    display: flex;
    align-items:center;
  }
  .upload-icon {
    width: 11px;
    height: 11px;
    margin-right: 6px;
  }
}
</style>
