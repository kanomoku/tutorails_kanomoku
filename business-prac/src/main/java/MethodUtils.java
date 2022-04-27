import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MethodUtils {
    public List<Integer> processTabIds(List<Integer> newTagIds, List<Integer> addTagIds, List<Integer> deleteTagIds,
        List<Integer> existingTagIds) {
        List<Integer> tagIds;
        if (CollectionUtils.isNotEmpty(existingTagIds)) {
            // 有既存的标签、就把他们当做源数据
            tagIds = existingTagIds;
        } else if (CollectionUtils.isNotEmpty(newTagIds)) {
            // 没有既存的标签、就把新传进来的newTagIds当做源数据
            tagIds = newTagIds;
        } else {
            // 没有既存的标签、也没有新传进来的newTagIds、把空列表当做源数据
            tagIds = new ArrayList<>();
        }

        // addTagIds,deleteTagIds都为空表示置换、用newTagIds整个替换原来的TagIds
        if (CollectionUtils.isEmpty(addTagIds) && CollectionUtils.isEmpty(deleteTagIds)) {
            if (CollectionUtils.isNotEmpty(newTagIds)) {
                tagIds = newTagIds;
            }
        } else {
            // addTagIds,deleteTagIds都有值得话走更新逻辑
            if (CollectionUtils.isNotEmpty(addTagIds)) {
                // 增加标签
                tagIds.addAll(addTagIds);
            }
            if (CollectionUtils.isNotEmpty(deleteTagIds)) {
                // 删除标签
                tagIds.removeAll(deleteTagIds);
            }
        }
        return tagIds.stream().distinct().collect(Collectors.toList());
    }
}
