# OS Identification
gradlew = "./gradlew"
expected_ref = "$EXPECTED_REF"
if os.name == "nt":
  gradlew = "gradlew.bat"
  expected_ref = "%EXPECTED_REF%"

# Build
custom_build(
    # Name of the container image
    ref = 'catalog-service',
    # Command to build the container image
    command = gradlew + ' bootBuildImage --imageName ' + expected_ref,
    # Files to watch that trigger a new build
    # deps = ['build.gradle', 'build/classes', 'src/main/resources'],
    deps = ['build.gradle', 'src'],

    # live_update = [
    #    sync('build/classes/java/main', '/workspace/BOOT-INF/classes'),
    #    sync('src/main/resources', '/workspace/BOOT-INF/classes')
    # ]
)

# local_resource(
#   'compile-java',
#   gradlew + ' compileJava',
#   deps=['src', 'build.gradle'])
 
# Deploy
k8s_yaml(['k8s/deployment.yml', 'k8s/service.yml'])

k8s_resource(
    workload='catalog-service',
    port_forwards=9001
)