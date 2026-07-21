lass Solution:

  def divide(self, dividend: int, divisor: int) -> int:
    # Handle the 32-bit signed integer overflow edge case
    INT_MIN, INT_MAX = -(2**31), 2**31 - 1
    if dividend == INT_MIN and divisor == -1:
      return INT_MAX

    # Determine if the result should be negative
    is_negative = (dividend < 0) ^ (divisor < 0)

    # Work with positive values
    a, b = abs(dividend), abs(divisor)
    quotient = 0

    # Exponential search / bit shifting
    while a >= b:
      temp = b
      multiple = 1

      # Double the divisor until it exceeds 'a'
      while a >= (temp << 1):
        temp <<= 1
        multiple <<= 1

      a -= temp
      quotient += multiple

    return -quotient if is_negative else quotient
