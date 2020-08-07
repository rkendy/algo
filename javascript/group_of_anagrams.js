/**
 * An anagram is a word or phrase formed by rearranging the letters
 * of a different word or phrase, typically using all the original
 * letters exactly once.
 *
 * Given an array of strings that contains anagrams, write a function
 * to print those anagrams.
 *
 * Input #
 * The input is an array of strings. Remember that spaces count as
 * characters! So " abc" and “cab” are technically not anagrams
 * since " abc" has spaces which “cab” does not.
 *
 * Output #
 * The output is a string array where all the anagrams are grouped
 * together.
 *
 * Sample output:
 * "[cat, tac, act][abc, cab][def, fed][clint eastwood , old west action]
 *  [tom marvolo riddle , i am lord voldemort][elvis, lives][dog, god]"
 */

function get_key(str) {
  arr_chars = [...str];
  arr_chars.sort();
  return arr_chars.join("");
}
function group_of_anagrams(arr) {
  map = new Map();
  arr.forEach((e) => {
    key = get_key(e);
    anagrams = map.get(key) || [];
    anagrams.push(e);
    map.set(key, anagrams);
  });
  result = [];
  for (var value of map.values()) {
    if (value.length > 1) {
      result.push("[" + value + "]");
    }
  }
  return (result + "").replace(/\]\,\[/g, "][").replace(/,/g, ", ");
}

input = [
  "cat",
  "dog",
  "tac",
  "god",
  "act",
  "tom marvolo riddle ",
  "abc",
  "def",
  "cab",
  "fed",
  "clint eastwood ",
  "i am lord voldemort",
  "elvis",
  "old west action",
  "lives",
];

result = group_of_anagrams(input);
console.log(result);
