import axios from 'axios';

const axiosClient = axios.create({
  baseURL: 'http://localhost:4001',
  headers: {
    Authorization:
      'Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtb2RjbG92ZXI3QGdtYWlsLmNvbSIsImlhdCI6MTY5NTY3MzMzNCwiZXhwIjoxNjk1NzU5NzM0fQ.saBb1gh4hO1VlpzsnU-bwzkIevHWOYvc7Fg_7OybzAA',
  },
});

export default axiosClient;
