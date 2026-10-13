// axiosInterceptor.js
import axios from 'axios';

const setupInterceptors = () => {
  axios.interceptors.response.use(
    (response) => {
    return response;
    },
    (error) => {
      if (error.response && error.response.status === 302) {
        // 如果状态码是302，执行页面跳转
        window.location.href = error.response.headers.location;
        return Promise.reject(new Error('Redirected')); // 返回一个被拒绝的Promise，避免进一步处理
      }

      // 其他的错误处理
      return Promise.reject(error);
    }
  );
  axios.interceptors.request.use(config => {
      // 修改以 './' 开头的 URL, 替换为/api/开头
      config.url = config.url.replace(/^\.\//, '/api/');
      return config;
  }, error => {
      // 处理请求错误
      return Promise.reject(error);
  });
};

export default setupInterceptors;