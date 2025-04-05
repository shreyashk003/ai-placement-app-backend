package mmec.ai.placement.ai_placement_app.Controller;

import org.springframework.web.bind.annotation.*;
import javax.script.*;

@RestController
@RequestMapping("/api/execute")
@CrossOrigin(origins = "http://localhost:3000")
public class ExecutionController {
    @PostMapping
    public String executeCode(@RequestBody CodeRequest codeRequest) {
        try {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
            Object result = engine.eval(codeRequest.getCode());
            return "{\"output\": \"" + result.toString() + "\"}";
        } catch (Exception e) {
            return "{\"output\": \"Error executing code\"}";
        }
    }
}

class CodeRequest {
    private String code;

    public String getCode() {
        return code;
    }
}

