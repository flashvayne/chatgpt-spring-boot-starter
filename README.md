[![Maven central](https://maven-badges.herokuapp.com/maven-central/io.github.flashvayne/chatgpt-spring-boot-starter/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.flashvayne/chatgpt-spring-boot-starter)

[中文版文档](https://vayne.cc/2022/12/17/chatgpt-spring-boot-starter)

# chatgpt-spring-boot-starter
use chatgpt in springboot project easily

## Usage
1.Add maven dependency.
```pom
<dependency>
    <groupId>io.github.flashvayne</groupId>
    <artifactId>chatgpt-spring-boot-starter</artifactId>
    <version>1.0.0</version>
</dependency>
```
2.Set chatgpt properties in your application.yml
```yml
chatgpt:
  api-key: xxxxxxxxxxx   #your api-key. It can be generated in the link https://beta.openai.com/docs/quickstart/adjust-your-settings
# some properties as below have default values. Of course, you can change them.
#  max-tokens: 300           # The maximum number of tokens to generate in the completion.The token count of your prompt plus max_tokens cannot exceed the model's context length. Most models have a context length of 2048 tokens (except for the newest models, which support 4096).
#  model: text-davinci-003   # GPT-3 models can understand and generate natural language. We offer four main models with different levels of power suitable for different tasks. Davinci is the most capable model, and Ada is the fastest.
#  temperature: 0.0          # What sampling temperature to use. Higher values means the model will take more risks. Try 0.9 for more creative applications, and 0 (argmax sampling) for ones with a well-defined answer.We generally recommend altering this or top_p but not both.
#  top-p: 1.0                # An alternative to sampling with temperature, called nucleus sampling, where the model considers the results of the tokens with top_p probability mass. So 0.1 means only the tokens comprising the top 10% probability mass are considered.We generally recommend altering this or temperature but not both.
```
3.Inject bean ChatgptService anywhere you require it, and invoke its method to send message to chatgpt and get the response.
```java
@Autowired
private ChatgptService chatgptService;

public void test(){
    String responseMessage = chatgptService.sendMessage("how are you");
    System.out.print(responseMessage); //I'm doing well, thank you. How about you?
}
```

## Demo project：
[demo-chatgpt-spring-boot-starter](https://github.com/flashvayne/demo-chatgpt-spring-boot-starter)

## Demo online experience
https://vayne.cc/chat/

*This demo does not work now, because my account's request times quota is exceeded.  
You can use your own account api-key to let your demo work.  

# Author Info
Email: flashvayne@gmail.com

Blog: https://vayne.cc
