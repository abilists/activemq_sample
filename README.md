# activemq_sample

Using
------------------
#### How to build
$ gradle clean build  

#### How to run

Receiver
```
ReceiverMain.java in Eclipse  
```
Sender
```
ObjectThreadSender.java in Eclipse - Using thread
PoolableObjectSender.java in Eclipse - Using pool
SimpleObjectSender.java in Eclipse - Using object
```

#### Notes

If you want to add a queue, need to add a receiver as below
```
<bean id="oneListener" class="io.jms.receiver.runnable.CommonJmsReceiver">
	<property name="listener">
		<bean class="io.jms.receiver.receiver.impl.OneListener"/>
	</property>
	<property name="queueName" value="oneQueue"/>
</bean>
```

#### Reference