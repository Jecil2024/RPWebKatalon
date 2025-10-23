import helper.EnvLoader

Map<String, String> env = EnvLoader.loadEnv()
println "Loaded SLACK_WEBHOOK_URL: ${env['SLACK_WEBHOOK_URL']}"
