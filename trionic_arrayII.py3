class Solution:
    def maxSumTrionic(self, nums: List[int]) -> int:
        n = len(nums)
        res = -(1 << 50)
        pSum = nums[0]
        l = 0
        p = 0
        q = 0
        for r in range(1, n):
            pSum += nums[r]
            if nums[r - 1] == nums[r]:
                l = r
                pSum = nums[r]
            elif nums[r - 1] > nums[r]:
                if r > 1 and nums[r - 2] < nums[r - 1]:
                    p = r - 1
                    while l < q:
                        pSum -= nums[l]
                        l += 1
                    while l + 1 < p and nums[l] < 0:
                        pSum -= nums[l]
                        l += 1
            else:
                if r > 1 and nums[r - 2] > nums[r - 1]:
                    q = r - 1
                if l < p and p < q:
                    res = max(res, pSum)

        return res
