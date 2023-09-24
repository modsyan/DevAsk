/* eslint-disable @typescript-eslint/no-var-requires */
/* eslint-disable no-undef */

import { resolve } from 'path';
import { plugins } from './postcss.config';

export const style = {
  postcss: {
    mode: 'extends',
    plugins: [
      require('tailwindcss')('./tailwind.config'),
      require('autoprefixer'),
    ].concat(plugins),

    env: {
      autoprefixer: {},
      stage: 3,
      feature: {},
    },
    // loaderOptions: {},
    // loaderOptions: (postcssLoaderOptions, {env, paths}) => {
    // },
  },
};
export const eslint = {
  enable: false,
};
export const webpack = {
  alias: {
    '@features': resolve(__dirname, 'src/features'),
    '@views': resolve(__dirname, 'src/views'),
    '@layouts': resolve(__dirname, 'src/layouts'),
    '@components': resolve(__dirname, 'src/components'),
    '@constants': resolve(__dirname, 'src/constants'),
  },
};
