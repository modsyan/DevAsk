import { createGlobalStyle } from 'styled-components';
import { normalize } from 'styled-normalize';
import { Theme } from './theme';

// export const GlobalStyle = createGlobalStyle<{ theme: Theme }>`
export const GlobalStyle = createGlobalStyle`
 ${normalize}

  @import url("https://fonts.googleapis.com/css2?family=Poppins:wght@200&display=swap");
  @tailwind base;
  @tailwind components;
  @tailwind utilities;

  .markdown > * {
    all: revet;
  }
`;
