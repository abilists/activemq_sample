#!/bin/sh

# Batch process check script - start
declare -i batchCnt=0
batchCnt=`ps -ef | grep "io.jms.receiver.main.ReceiverMain" | grep -v "grep --color=auto io.jms.receiver.main.ReceiverMain" | wc -l`
if [ $batchCnt -gt 1 ]
then
        echo "ReceiverMain already started !!"
        exit 0
fi
# Batch batch process check script - end

VERSION="v1.0.0"
# Program Name (Class Name)
PROGRAM_NAME=io.jms.receiver.main.ReceiverMain

# Define Environment Variable
JAVA_HOME=/usr/local/java
JMS_HOME=/usr/local/app/jms
export JAVA_HOME
LOG_FILE=${JMS_HOME}/logs/jmsReceiver.log
STOP_FILE_PATH=${JMS_HOME}/stop.txt

# Set Classpath
for f in `find $JMS_HOME/libs -type f -name "*.jar"`
do
   CLASSPATH=$CLASSPATH:$f
done

CLASSPATH=${CLASSPATH}:${JMS_HOME}/bin/batchSample-${VERSION}.jar

# Change Directory
cd ${JMS_HOME}/bin

# JAVA Execute
if [ -e ${STOP_FILE_PATH} ];
then
    rm -f ${STOP_FILE_PATH}
fi

OPT="-server -Xmx256m -Xms256m -Xmn128m -classpath ${CLASSPATH} "

${JAVA_HOME}/bin/java $OPT ${PROGRAM_NAME} >> ${LOG_FILE}

exit 0