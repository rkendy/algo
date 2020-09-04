function sieve(n) {
  var sieve = new Array(n + 1).fill(true);
  sieve[0] = sieve[1] = false;

  var i = 2;
  while (i * i <= n) {
    if (sieve[i]) {
      var k = i * i;
      while (k <= n) {
        sieve[k] = false;
        k += i;
      }
    }
    i += 1;
  }
  return sieve;
}

sieve(30).forEach((v, i) => {
  console.log(i + ": " + v);
});
