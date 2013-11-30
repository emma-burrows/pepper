$(document).ready(function() {
  // Prepare autocomplete options for the search input.
  $("#search").typeahead({
    name: "names",
    prefetch: {
      url: "rest/autocomplete.json",
      ttl: 0
    },
    limit: 5
  });

  // Replace each number in every formula with <sub>number</sub>.
  $(".formula").html(function(_, html) {
    return html.replace(/(\d+)/g, '<sub>$1</sub>');
  });
});
