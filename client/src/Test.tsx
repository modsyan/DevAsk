// // import axios from 'axios';

import axiosClient from './utils/axiosClient';

// // import axiosClient from './utils/axiosClient';
export const Test = () => {
  const data = axiosClient
    .get('/questions')
    .then((res) => console.log(res.data));

  return <div className="flex flex-col gap-3"></div>;
};
