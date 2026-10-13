export default {
  setState (state, object) {
    for (let key in object) {
      state[key] = object[key]
    }
  }
}
