function fn() {
  var env = karate.env || 'qa';
  karate.log('Running Karate tests on environment:', env);

  var config = {
    env: env,
    baseUrl: '',

    headersAuth: { 'Content-Type': 'application/json' },
    headersBooking: { 'Content-Type': 'application/json' },
    headersGetBooking: { 'Accept': 'application/json' },

    headerUpdateBooking: function(token) {
      return {
        'Content-Type': 'application/json',
        'Accept': 'application/json',
        'Cookie': 'token=' + token
      }
    }
  };

  if (env === 'qa') {
    config.baseUrl = 'https://restful-booker.herokuapp.com';
  }

  config.randomNumber = function() {
   return Math.floor(Math.random() * 250);
  };

  karate.configure('ssl', true);
  karate.configure('logPrettyRequest', true);
  karate.configure('logPrettyResponse', true);
  return config;
}
