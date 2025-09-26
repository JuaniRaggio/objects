if [ $# -ne 2 ]; then
    echo "Necesito: @nombre_paquete @nombre_proyecto"
    exit 1
fi

mvn archetype:generate -DgroupId=com.$1 -DartifactId=$2 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
