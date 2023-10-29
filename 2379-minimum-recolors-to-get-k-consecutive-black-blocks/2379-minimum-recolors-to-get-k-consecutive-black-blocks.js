var minimumRecolors = function (blocks, k) {
    let min = Infinity;
    let start = 0;
    let currentMin = 0;
    for (let end = 0; end < blocks.length; end++) {
        if (blocks[end] === 'W') currentMin++;
        if (end - start + 1 == k) {
            min = Math.min(currentMin, min);
            if (blocks[start++] === 'W') {
                currentMin--
            }
        }
    }

    return min;
};