import asyncio
import time
import inspect

"""_summary_
https://dongwooklee96.github.io/post/2021/09/05/%ED%8C%8C%EC%9D%B4%EC%8D%AC-asyncio-%EC%82%AC%EC%9A%A9%EB%B2%95-%EB%B0%8F-%EC%98%88%EC%A0%9C.html
"""


async def main():
    print(f'{time.ctime()} Hello!')
    await asyncio.sleep(1.0)
    print(f'{time.ctime()} GoodBye!')

print(type(main))  # <class 'function'>
print(inspect.iscoroutinefunction(main))  # True

# 코루틴을 실행하기 위한 루프 인스턴스를 얻는 방법이다.
loop = asyncio.get_event_loop()
# create_task()를 호출해서 루프에 코루틴을 스케줄링 한다.
task = loop.create_task(main())

# 호출을 통해 현재 스레드를 블로킹 할 수 있다. 루프가 실행되는 동안 다른 작업들도 같이 실행된다.
# asyncio.run() 도 내부에서 run_until_complete()를 호출하여 메인 스레드를 블로킹한다.
loop.run_until_complete(task)

pending = asyncio.all_tasks(loop=loop)
for task in pending:
    task.cancel()

# 루프 중지 증으로 블로킹 상태가 풀린 후에 아직 실행중인 태스크를 취합하고
# 모든 태스크에게 취소 요청을 한 후에 loop.run_until_complete()를 호출하여 태스크들이 모두 종료 상태가 될 때까지 기다린다.
# asyncio.run()의 내부에서 위의 절차를 모두 포함한다.
group = asyncio.gather(*pending, return_exceptions=True)
loop.run_until_complete(group)

# 보통 최종 동작이다. 모든 루프의 대기열을 비우고 익스큐터를 종료시킨다.
# asyncio.run() 내부에서는 호출될 때마다 신규 이벤트 루프를 생성하고 반환하기 전에 루프를 닫는다.
loop.close()
