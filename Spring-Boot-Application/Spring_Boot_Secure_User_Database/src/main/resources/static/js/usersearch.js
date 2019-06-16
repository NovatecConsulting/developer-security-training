function validateUsersearchField() {
    var usersearchInput = document.getElementById("searchInput").value;
    var usersearchInputEscaped = validateHTML(usersearchInput);
    document.getElementById("searchLabel").innerHTML = "Search Results for username: " + usersearchInputEscaped;
}

function validateHTML(input) {
    var userInputNew = safe_tags_replace(input);
    return userInputNew;
}

function escapeTag(tag) {
    return escapeCharacterList[tag] || tag;
}

var escapeCharacterList = {
    '&': '&amp;',
    '<': '&lt;',
    '>': '&gt;',
    '"': '&quot;',
    '\'': '&#x27;',
    '/': '&#x2F;'
};

function safe_tags_replace(str) {
    return str.replace(/[&<>]/g, escapeTag);
}