$(document).ready(function() {

  // Prepare autocomplete options for the search input.
  $.getJSON('rest/autocomplete.json', function(data) {
    $("#search").autocomplete({
      // Use the JSON returned from the REST call as the source data.
      source: data,

      // Automatically highlight the top item.
      autoFocus: true,

      // Don't display any helper messages.
      messages: {
        noResults: '',
        results: function() {}
      },

      // After pressing tab, return the focus to the search input.
      select: function(event, ui) {
        if(event.keyCode === $.ui.keyCode.TAB)
        {
          event.preventDefault();
          this.value = ui.item.value;
          $("#search").focus();
        }
      }

    });
  });

  // Replace each number in every formula with <sub>number</sub>.
  $(".formula").html(function(_, html) {
    return html.replace(/(\d+)/g, '<sub>$1</sub>');
  });

});
