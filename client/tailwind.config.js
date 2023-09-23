/** @type {import('tailwindcss').Config} */

// export const content = ['./src/**/*.{js,jsx,ts,tsx}'];
export const content = ['./public/index.html', './src/**/*.{js,jsx,ts,tsx}'];
// export const purge = ['./src/**/*.{js,jsx,ts,tsx}', './public/index.html'];

export const theme = {
  extend: {
    fontFamily: {
      poppins: ['Poppins', 'sans-serif'],
    },

    colors: {
      brand: {
        50: '#4480db',
        100: '#306dc8',
        200: '#2e5da3',
        300: '#2b4d80',
        400: '#213b63',
        500: '#1f324f',
        600: '#1b283c',
        700: '#161e2b',
        800: '#0f141a',
        900: '#07090b',
      },
    },
  },
};

export const plugins = [require('@tailwindcss/typography')];
