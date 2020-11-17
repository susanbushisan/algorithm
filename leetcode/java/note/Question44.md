    *比较特殊，分情况讨论，如果没有*号，那么只用管？和判断两者的长度了，如果有*，用*分割字符串，分三种情况，开头没有*的，结尾没有*的，两边都要*的，如果一个字符模式存在*号，那么有且只有一次发生前两种情况（如果是*开头或者结尾的话就是空串符合），中间再顺序比较。  
    正常的解法是DP，粗略看了下头疼没看懂

###方法一：常规硬解

开头相等，中间找最开始匹配的,然后匹配最后面的

~~~
public boolean isMatch(String s, String p) {
    List<String> split = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < p.length(); i++) {
        char c = p.charAt(i);
        if (c == '*') {
            split.add(new String(sb));
            sb.setLength(0);
        } else {
            sb.append(c);
        }
    }
    split.add(new String(sb));
    //情况1，左右无*
    if (split.size() == 1){
        if (s.length() != p.length()){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = p.charAt(i);
            if (s.charAt(i) != c && c != '?'){
                return false;
            }
        }
        return true;
    }
    String target = s;
    if (likeStartWith(target,split.get(0))){
        target = target.substring(split.get(0).length());
    }else {
        return false;
    }
    for (int i = 1; i < split.size() - 1; i++) {
        int index = likeEquals(target,split.get(i));
        if (index != -1){
            target = target.substring(index);
        }else {
            return false;
        }
    }
    return likeEndWith(target,split.get(split.size() - 1));

}

private boolean likeStartWith(String target, String s) {
    if (target.length() < s.length()){
        return false;
    }
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (target.charAt(i) != c && c != '?'){
            return false;
        }
    }
    return true;
}

private boolean likeEndWith(String target, String s) {
    int index = target.length() - s.length();
    if (index<0){
        return false;
    }
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (target.charAt(i +index) != c && c != '?'){
            return false;
        }
    }
    return true;
}

private int likeEquals(String source, String p) {
    if (p.length() > source.length()) {
        return -1;
    }
    for (int i = 0; i <= source.length() - p.length(); i++) {
        boolean flag = true;
        for (int j = 0; j < p.length(); j++) {
            char t = p.charAt(j);
            if (source.charAt(i + j) != t && t != '?') {
                flag = false;
                break;
            }
        }
        if (flag) {
            return i + p.length();
        }
    }
    return -1;
}
~~~

###方法二：动态规划

~~~

~~~

代码实现 src/Question44.isMatch
DP代码实现 src/Question44.isMatchEasy
