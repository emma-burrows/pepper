$(document).ready(function() {
  // Replace each number in the formula with <sub>number</sub>
  $(".formula").html(function(_, html) {
    return html.replace(/(\d+)/g, '<sub>$1</sub>');
  });
});
