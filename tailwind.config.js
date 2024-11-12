/** @type {import('tailwindcss').Config} */
module.exports = {
    content: [
        './src/**/*.kt',
        './src/**/*.html'
    ],
    theme: {
        extend: {
            colors: {
                customGray: '#303030',
                customBlack: '#0f0f0f',
            },
            scrollbar: ['hide'],
            fontFamily: {
                roboto: ['Roboto', 'sans-serif'],
            },
        },
    },
    plugins: [
        require('tailwind-scrollbar-hide')
    ],
}

