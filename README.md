Simple ActiveMQ source module.
It is a Spring-XD module which consumes messages from a queue.

xd> module upload --file xxx --name --type source

xd> stream create --name jmsTest --definition "xxx | file" --deploy