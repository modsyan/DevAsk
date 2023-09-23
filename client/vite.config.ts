import { defineConfig } from 'vite';
import reactRefresh from '@vitejs/plugin-react-refresh';
import svgPlugin from 'vite-plugin-svgr';
import path, { resolve } from 'path';

export default defineConfig({
  build: {
    outDir: 'build',
    rollupOptions: {
      input: {
        main: resolve(__dirname, 'index.html'),
      },
    },
  },
  plugins: [
    reactRefresh(),
    svgPlugin({
      svgrOptions: {
        icon: true,
      },
    }),
  ],
  resolve: {
    alias: [
      {
        find: '@features',
        replacement: path.resolve(__dirname, '/src/features'),
      },
      { find: '@layouts/', replacement: path.resolve(__dirname, '/src/layouts') },
      {
        find: '@components',
        replacement: path.resolve(__dirname, '/src/components'),
      },
      {
        find: '@constants',
        replacement: path.resolve(__dirname, '/src/constants'),
      },
    ],
  },
});
