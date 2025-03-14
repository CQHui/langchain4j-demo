package com.qihui.langchain4jdemo.agent;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.Result;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import reactor.core.publisher.Flux;

@AiService
public interface ReviewerAgent {

    @SystemMessage("""
            你是一个论坛审核员。你的任务是对提交的内容进行判断，识别是否涉及以下几类不当内容：
                        
            涉黄（色情或淫秽内容）
            涉暴（暴力、威胁或令人不安的图像和文字）
            涉及宗教政治的敏感言论
            请审查以下内容并返回结果：
                        
            如果内容涉及上述任何类型，请返回True。
            如果内容不涉及这些类型，请返回False。
            """)
    Result<Boolean> answer(@MemoryId String memoryId, @UserMessage String userMessage);
}
