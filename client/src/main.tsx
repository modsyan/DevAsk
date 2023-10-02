import React from 'react';
import ReactDOM from 'react-dom/client';

import { App } from './App';
import './styles/global.css';
import GlobalStyles from './styles/global.style';

ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
  <React.StrictMode>
    <GlobalStyles />
    <App />
  </React.StrictMode>
);
