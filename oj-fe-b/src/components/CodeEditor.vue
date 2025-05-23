<template>
  <div ref="editorform" class="ace-editor">
  </div>
</template>

<script setup>
import { ref, onMounted, onBeforeUnmount } from "vue"
import ace from "ace-builds"
import "ace-builds/src-noconflict/mode-java"
import "ace-builds/src-noconflict/theme-eclipse"
import "ace-builds/src-noconflict/ext-language_tools";

// 定义选项
const options = {
  theme: `ace/theme/eclipse`,
  mode: `ace/mode/java`,
  maxLines: 20,
  minLines: 10,
  fontSize: 15,
  enableBasicAutocompletion: true,
  enableLiveAutocompletion: true,
  enableSnippets: true,
  showPrintMargin: false,
  showGutter: true,
  highlightActiveLine: true,
  tabSize: 4,
  useSoftTabs: true,
  wrap: true
};
// 创建响应式引用
let editor = null;
const emit = defineEmits(['update:value']);
const editorform = ref(null);
// 初始化编辑器
onMounted(() => {
  editor = ace.edit(editorform.value, options);
  editor.setOptions({
    enableBasicAutocompletion: true,
    enableLiveAutocompletion: true,
    enableSnippets: true
  });
  // 添加常用的 Java 代码片段
  const langTools = ace.require("ace/ext/language_tools");
  const completer = {
    getCompletions: function(editor, session, pos, prefix, callback) {
      const wordList = [
        {caption: "System.out.println", value: "System.out.println($1);", meta: "snippet"},
        {caption: "public static void main", value: "public static void main(String[] args) {\n\t$1\n}", meta: "snippet"},
        {caption: "for", value: "for (int i = 0; i < $1.length; i++) {\n\t$2\n}", meta: "snippet"},
        {caption: "while", value: "while ($1) {\n\t$2\n}", meta: "snippet"},
        {caption: "if", value: "if ($1) {\n\t$2\n}", meta: "snippet"},
        {caption: "try", value: "try {\n\t$1\n} catch (Exception e) {\n\t$2\n}", meta: "snippet"}
      ];
      callback(null, wordList);
    }
  };
  langTools.addCompleter(completer);
  
  editor.getSession().on('change', () => {
    // 当编辑器内容变化时，触发自定义事件并传递编辑器的内容
    emit('update:value', editor.getValue());
  });
});

// 销毁编辑器实例
onBeforeUnmount(() => {
  if (editor) {
    editor.destroy();
    editor = null;
  }
});

function setAceCode(content) {
  editor.setValue(content)
}

defineExpose({
  setAceCode
})


</script>

<style lang="scss" scoped>
.ace-editor {
  margin: 10px 0 0 0;
  width: 90%;
}
</style>