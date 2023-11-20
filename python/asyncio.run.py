import asyncio
import time

"""_summary_
https://dongwooklee96.github.io/post/2021/09/05/%ED%8C%8C%EC%9D%B4%EC%8D%AC-asyncio-%EC%82%AC%EC%9A%A9%EB%B2%95-%EB%B0%8F-%EC%98%88%EC%A0%9C.html
"""


async def main():
    print(f'{time.ctime()} Hello!')
    await asyncio.sleep(1.0)
    print(f'{time.ctime()} GoodBye!')


asyncio.run(main())
