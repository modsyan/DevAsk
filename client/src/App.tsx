import { QueryClient, QueryClientProvider } from 'react-query';
import { RouterProvider } from 'react-router-dom';
import { router } from './routes';
// import './styles/global.css';
// import { GlobalStyle } from './styles/global.style';
// import { theme } from './styles/theme';

const queryClient = new QueryClient();

export const App = () => {
  return (
    <>
      <QueryClientProvider client={queryClient}>
        {/* <GlobalStyle theme={theme} /> */}
        <RouterProvider router={router} />
      </QueryClientProvider>
    </>
  );
};
