/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */
var flat = function (arr, n) {
    if(n==0){
        return arr.slice();
    }
    let newArr = [];
    arr.forEach((val) => {
        if(Array.isArray(val)){
            const nested = flat(val, n-1);
            newArr.push(...nested);
        }
        else{
            newArr.push(val);
        }
    });
    return newArr;
};