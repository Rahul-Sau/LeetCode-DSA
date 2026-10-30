/**
 * @param {Array} arr
 * @param {number} size
 * @return {Array}
 */
var chunk = function (arr, size) {
    let n = []
    let i = 0
    while (i < arr.length) {
        n.push(arr.slice(i, i + size))
        i += size
    }
    return n
};
