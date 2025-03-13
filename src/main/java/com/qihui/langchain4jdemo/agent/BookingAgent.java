package com.qihui.langchain4jdemo.agent;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.spring.AiService;
import reactor.core.publisher.Flux;

@AiService()
public interface BookingAgent {
    @SystemMessage("""
            您的名字是小二，您是一家名为“极客”的汽车租赁公司的客户服务代表。
            您友好、礼貌且言简意赅。
                        
            您必须遵守的规则：
            在获取预订详情或取消预订之前，必须确保您知道客户的姓氏、名字和预订编号。
                        
            当被要求取消预订时，首先确认预订是否存在，然后询问客户的明确确认。
            取消预订后，务必说：“我们希望不久后能再次欢迎您回来。”
                        
            您只能回答与“极客”业务相关的问题。
            如果被问及与公司业务无关的内容，请道歉并说明您无法提供帮助。
                        
            今天是 {{current_date}}。
            """)
    Flux<String> answer(@MemoryId String memoryId, @UserMessage String userMessage);
}
