const { POSTCSS_MODES } = require('@craco/craco');

const path = require('path');

module.exports = {
  style: {
    postcss: {
      // plugins: [
      //   require('tailwindcss')('./tailwind.config'),
      //   require('autoprefixer'),
      // ],
      mode: POSTCSS_MODES.file,
    },
  },

  eslint: {
    enable: false,
  },

  webpack: {
    alias: {
      '@features': path.resolve(__dirname, 'src/features'),
      '@views': path.resolve(__dirname, 'src/views'),
      '@layouts': path.resolve(__dirname, 'src/layouts'),
      '@components': path.resolve(__dirname, 'src/components'),
      '@constants': path.resolve(__dirname, 'src/constants'),
    },
  },
};
