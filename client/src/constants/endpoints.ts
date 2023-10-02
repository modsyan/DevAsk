export type EndpointConfig = {
  url: string;
  method: 'post' | 'get' | 'patch' | 'delete';
  auth: boolean;
};

export enum Endpoints {
  login = 'login',

  register = 'register',

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

export const baseApiUrl: string = `https://muze-inherited-failing-interval.trycloudflare.com/api/v1`;

export const ENDPOINT_CONFIGS: { [key in Endpoints]: EndpointConfig } = {
  [Endpoints.login]: {
    url: `${baseApiUrl}/login`,
    method: 'post',
    auth: false,
  },

  [Endpoints.register]: {
    url: `${baseApiUrl}/login`,
    method: 'post',
    auth: false,
  },

  [Endpoints.getQuestions]: {
    url: `${baseApiUrl}/login`,
    method: 'post',
    auth: false,
  },

  [Endpoints.getQuestionDetail]: {
    url: `${baseApiUrl}/login`,
    method: 'post',
    auth: false,
  },

  [Endpoints.askQuestions]: {
    url: `${baseApiUrl}/login`,
    method: 'post',
    auth: true,
  },

  [Endpoints.deleteQuestions]: {
    url: `${baseApiUrl}/login`,
    method: 'post',
    auth: true,
  },

  [Endpoints.updateQuestions]: {
    url: `${baseApiUrl}/login`,
    method: 'patch',
    auth: true,
  },

  [Endpoints.addSolutions]: {
    url: `${baseApiUrl}/login`,
    method: 'post',
    auth: true,
  },

  [Endpoints.getSolutionsDetail]: {
    url: `${baseApiUrl}/login`,
    method: 'post',
    auth: false,
  },

  [Endpoints.getQuestionSolution]: {
    url: `${baseApiUrl}/login`,
    method: 'post',
    auth: false,
  },

  [Endpoints.countQuestionSolution]: {
    url: `${baseApiUrl}/login`,
    method: 'post',
    auth: false,
  },

  [Endpoints.deleteSolutions]: {
    url: `${baseApiUrl}/login`,
    method: 'post',
    auth: true,
  },

  [Endpoints.updateSolution]: {
    url: `${baseApiUrl}/login`,
    method: 'patch',
    auth: true,
  },

  [Endpoints.addComments]: {
    url: `${baseApiUrl}/login`,
    method: 'post',
    auth: true,
  },

  [Endpoints.deleteComments]: {
    url: `${baseApiUrl}/login`,
    method: 'post',
    auth: true,
  },

  [Endpoints.getQuestionComments]: {
    url: `${baseApiUrl}/login`,
    method: 'post',
    auth: false,
  },

  [Endpoints.countQuestionComments]: {
    url: `${baseApiUrl}/login`,
    method: 'post',
    auth: false,
  },

  [Endpoints.getCommentDetail]: {
    url: `${baseApiUrl}/login`,
    method: 'post',
    auth: false,
  },

  [Endpoints.voteUP]: {
    url: `${baseApiUrl}/login`,
    method: 'post',
    auth: true,
  },

  [Endpoints.voteDown]: {
    url: `${baseApiUrl}/login`,
    method: 'post',
    auth: true,
  },
};
