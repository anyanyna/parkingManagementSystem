/** @type {import('tailwindcss').Config} */
// const spacing = {};
// for (let i = 0; i < 3000; i++) {
// 	spacing[i] = i + 'px';
// }
export default {
  content: [
    "./index.html",
    "./src/**/*.{vue,js,ts,jsx,tsx}",
  ],
  theme: {
    // spacing,
    extend: {},
  },
  plugins: [],
}