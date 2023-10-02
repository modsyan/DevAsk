import { createBrowserRouter } from 'react-router-dom';

// import { Login, Register } from '@views';
// import { Home } from '@views/home';
import { Login, Register } from '@views/auth';
import { Home } from '@views/home';
import { Feed, QuestionDetails } from '@features/questions/index.ts';
import { LoginForm } from '@features/auth';

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
    element: <LoginForm />,
    errorElement: <h1>Error Page</h1>,
  },
]);
