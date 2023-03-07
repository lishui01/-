def maxSubArray(nums):
    dp = [0] * len(nums)
    dp[0] = nums[0]
    for i in range(1,len(nums)):
        dp[i] = max(dp[i-1] + nums[i],nums[i])
    return max(dp)

def maxSubArray(nums):
    pre,result = 0, nums[0]
    for el in nums:
        pre = max(pre + el,el)  
        result = max(result,pre)
    return  result
if __name__ == "__main__":
    a=input('列表:').split(",")
    nums=[int(a[i]) for i in range(len(a))]
    print(maxSubArray(nums))
