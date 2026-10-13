const files = require.context('.', false, /\.js$/)
const action = {}
files.keys().forEach(key => {
    if (key === './index.js') return
    Object.assign(action, files(key).default)
})

export default action
