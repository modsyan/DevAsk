export type EndpointConfig = {
  url: string;
  method: 'post' | 'get' | 'patch' | 'delete';
  auth: boolean;
};

export enum Endpoints {
  login = 'login',

  register = 'register',

  getUserById = 'getUserById',

  getQuestions = 'getQuestions',
  getQuestionDetail = 'getQuestionDetail',
  askQuestions = 'askQuestions',
  deleteQuestions = 'deleteQuestions',
  updateQuestions = 'updateQuestions',

  addSolutions = 'addSolutions',
  getSolutionsDetail = 'getSolutionsDetail',
  getQuestionSolution = 'getQuestionSolution',
  countQuestionSolution = 'countQuestionSolution',
  deleteSolutions = 'deleteSolutions',
  updateSolution = 'updateSolution',

  addComments = 'addComments',
  deleteComments = 'deleteComments',
  getQuestionComments = 'getQuestionComments',
  countQuestionComments = 'countQuestionComments',
  getCommentDetail = 'getCommentDetail',

  voteUP = 'voteUP',
  voteDown = 'voteDown',
}

export const API_URL: string = import.meta.env.DEV
  ? import.meta.env.VITE_BASE_URL_DEV
  : import.meta.env.VITE_BASE_URL_PROD;

export const ENDPOINT_CONFIGS: { [key in Endpoints]: EndpointConfig } = {
  [Endpoints.login]: {
    url: `${API_URL}/login`,
    method: 'post',
    auth: false,
  },

  [Endpoints.register]: {
    url: `${API_URL}/login`,
    method: 'post',
    auth: false,
  },

  [Endpoints.getQuestions]: {
    url: `${API_URL}/questions`,
    method: 'get',
    auth: true,
  },

  [Endpoints.getQuestionDetail]: {
    url: `${API_URL}/questions`,
    method: 'get',
    auth: true,
  },

  [Endpoints.askQuestions]: {
    url: `${API_URL}/login`,
    method: 'post',
    auth: true,
  },

  [Endpoints.deleteQuestions]: {
    url: `${API_URL}/login`,
    method: 'post',
    auth: true,
  },

  [Endpoints.updateQuestions]: {
    url: `${API_URL}/login`,
    method: 'patch',
    auth: true,
  },

  [Endpoints.addSolutions]: {
    url: `${API_URL}/login`,
    method: 'post',
    auth: true,
  },

  [Endpoints.getSolutionsDetail]: {
    url: `${API_URL}/login`,
    method: 'post',
    auth: false,
  },

  [Endpoints.getQuestionSolution]: {
    url: `${API_URL}/login`,
    method: 'post',
    auth: false,
  },

  [Endpoints.countQuestionSolution]: {
    url: `${API_URL}/login`,
    method: 'post',
    auth: false,
  },

  [Endpoints.deleteSolutions]: {
    url: `${API_URL}/login`,
    method: 'post',
    auth: true,
  },

  [Endpoints.updateSolution]: {
    url: `${API_URL}/login`,
    method: 'patch',
    auth: true,
  },

  [Endpoints.addComments]: {
    url: `${API_URL}/login`,
    method: 'post',
    auth: true,
  },

  [Endpoints.deleteComments]: {
    url: `${API_URL}/login`,
    method: 'post',
    auth: true,
  },

  [Endpoints.getQuestionComments]: {
    url: `${API_URL}/login`,
    method: 'post',
    auth: false,
  },

  [Endpoints.countQuestionComments]: {
    url: `${API_URL}/login`,
    method: 'post',
    auth: false,
  },

  [Endpoints.getCommentDetail]: {
    url: `${API_URL}/login`,
    method: 'post',
    auth: false,
  },

  [Endpoints.voteUP]: {
    url: `${API_URL}/login`,
    method: 'post',
    auth: true,
  },

  [Endpoints.voteDown]: {
    url: `${API_URL}/login`,
    method: 'post',
    auth: true,
  },
  [Endpoints.getUserById]: {
    // url: `${baseApiUrl}/users/:id`,
    url: `${API_URL}/users/`,
    method: 'post',
    auth: false,
  },
};
