import { createBrowserRouter } from 'react-router-dom';

// import { Login, Register } from '@views';
// import { Home } from '@views/home';
import { Login, Register } from '@views/auth';
import { Home } from '@views/home';
import { Test } from './Test.tsx';
import { Spinner, NotFound } from '@components';
import { Feed } from '@views/questions/feed/';
import { QuestionDetails } from '@views/questions/detail/question-detail.view.tsx';

// import {Login, Register} from './views/auth'
// import { Home } from './views/home'

export const router = createBrowserRouter([
  {
    path: '/',
    element: <Home />,
    errorElement: <h1>Error Page</h1>,
  },

  {
    path: '/register',
    element: <Register />,
    errorElement: <h1>Error Page</h1>,
  },

  {
    path: '/login',
    element: <Login />,
    errorElement: <h1>Error Page</h1>,
  },
  {
    path: '/feed',
    element: <Feed />,
    errorElement: <h1>Error Page</h1>,
  },
  {
    path: '/questions/:id',
    element: <QuestionDetails />,
    errorElement: <h1>Error Page</h1>,
  },
  {
    path: '/test',
    element: <Test />,
    errorElement: <h1>Error Page</h1>,
  },
  {
    path: '/notfound',
    element: <NotFound/>
  },
]);
