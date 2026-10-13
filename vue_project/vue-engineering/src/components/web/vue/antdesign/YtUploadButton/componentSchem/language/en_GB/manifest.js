export default {
  template: `<div ref class="webVueAntYtPicture _$customClassName$_">
    <a-image
      :src="_$image.image$_"
      :preview="false"
      :style="{
        transform:_$image.transform$_,
        objectFit:_$image.objectFit$_
      }"
    />
  </div>`,
  clazzType: 'YtPicture'
}