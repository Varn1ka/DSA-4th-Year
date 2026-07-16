public List<String> AllPossibleStrings(String s) {
    List<String> ans = new ArrayList<>();
    generate(s, 0, new StringBuilder(), ans);
    Collections.sort(ans);
    return ans;
}

private void generate(String s, int idx, StringBuilder curr, List<String> ans) {
    if (idx == s.length()) {
        if (curr.length() > 0)
            ans.add(curr.toString());
        return;
    }
    curr.append(s.charAt(idx));
    generate(s, idx + 1, curr, ans);
    curr.deleteCharAt(curr.length() - 1);
    generate(s, idx + 1, curr, ans);
}
