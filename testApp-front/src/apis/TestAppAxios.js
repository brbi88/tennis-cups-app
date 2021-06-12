import axios from 'axios';

var TestAxios = axios.create({
    baseURL: 'http://localhost:8080/api'

});

TestAxios.interceptors.request.use(
    function success(config){
      const token = window.localStorage['jwt'];
      if (token){
        config.headers['Authorization'] = 'Bearer ' + token;
      }
      return config;
    }
  );
  
  
  

export default TestAxios;