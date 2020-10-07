function fn() {
    var config = {};
    var env = karate.env; // get java system property 'karate.env'
    config.env = { name: env };


    // sample
    if (env == 'unit-test') {
        // over-ride only those that need to be
        config.env.httpScheme = 'http';
        config.env.appUrl = 'localhost';
        config.env.appPort = karate.properties['demo.server.port']
        if(!config.env.appPort) {
            config.env.appappPort = 8080
        }
    } else {
        config.someUrlBase = 'https://e2e-host/v1/auth';
    }

    // common functions / features
    config.Utils = karate.callSingle('classpath:karate/framework-utils.feature');

    // don't waste time waiting for a connection or if servers don't respond within 5 seconds
    karate.configure('connectTimeout', 25000);
    karate.configure('readTimeout', 25000);

    return config;

}