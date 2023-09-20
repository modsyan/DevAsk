import { createBrowserRouter } from 'react-router-dom';
import { App } from './App';
import { Landing } from './pages/Home';
import { Register } from './pages/Auth/Register';

export const router = createBrowserRouter([
  {
    path: '/',
    element: <Landing />,
    errorElement: <h1>Error Page</h1>,
  },

  // {
  //   path: '/register',
  //   element: <Register />,
  //   errorElement: <h1>Error Page</h1>,
  // },

  // {
  //   path: '/login',
  //   element: <App />,
  //   errorElement: <h1>Error Page</h1>,
  // },

  // {
  //   path: '/verify',
  //   element: <App />,
  //   errorElement: <h1>Error Page</h1>,
  // },

  // {
  //   path: '/profile',
  //   element: <App />,
  //   errorElement: <h1>Error Page</h1>,
  // },

  // {
  //   path: '/questions',
  //   element: <App />,
  //   errorElement: <h1>Error Page</h1>,
  // },

  // {
  //   path: '/questions/:id',
  //   element: <App />,
  //   errorElement: <h1>Error Page</h1>,
  // },
]);
