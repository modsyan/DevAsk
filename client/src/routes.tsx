import { createBrowserRouter } from 'react-router-dom';

// import { Login, Register } from '@views';
// import { Home } from '@views/home';
import { Login, Register } from '@views/auth';
import { Home } from '@views/home';

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
]);
