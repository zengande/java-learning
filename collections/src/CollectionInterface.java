import java.util.*;

public class CollectionInterface {
    public static void main(String[] args) {
        Collection<String> c = new HashSet<>();

        Collection<String> d = Arrays.asList("one", "two");
        Collection<String> e = Collections.singleton("three");

        // 添加元素
        c.add("zero");
        c.addAll(d);

        // 复制
        Collection<String> copy = new ArrayList<String>(c);

        // 移除元素
        // 除了 clear 方法外，如果集合的内容发生变化，都返回 true
        c.remove("zero");
        c.removeAll(e);
        c.retainAll(d);
        c.clear();

        // 获取集合长度
        boolean b = c.isEmpty();
        int s = c.size();

        c.addAll(copy);

        System.out.println(c);

        c.stream()
                .map(String::length)
                .forEach(System.out::println);
    }
}
