import asyncio
from concurrent.futures import ThreadPoolExecutor

"""_summary_
https://www.pythonsheets.com/notes/python-asyncio.html
"""

e = ThreadPoolExecutor()


async def read_file(file_):
    print('read_file')
    await asyncio.sleep(1)
    loop = asyncio.get_event_loop()
    with open(file_) as f:
        return (await loop.run_in_executor(e, f.read))

ret = asyncio.run(read_file('/etc/passwd'))
print(ret)
